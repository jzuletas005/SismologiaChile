/*
 * Copyright [2020] [Javier Zuleta Silva]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cl.ucn.disc.dsm.sismologiachile.activities;

import android.os.AsyncTask;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import cl.ucn.disc.dsm.sismologiachile.activities.adapters.AlertaAdapter;
import cl.ucn.disc.dsm.sismologiachile.activities.adapters.AlertaViewModel;
import cl.ucn.disc.dsm.sismologiachile.databinding.ActivityMainBinding;
import es.dmoral.toasty.Toasty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(MainActivity.class);

  /**
   * The bindings.
   */
  private ActivityMainBinding binding;
  /**
   * adapter
   */
  private AlertaAdapter alertaAdapter;
  /**
   * viewmodel
   */
  private AlertaViewModel alertaViewModel;


  /**
   * OnCreate
    * @param savedInstanceState to use
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_main);
    // Inflate the layout
    this.binding = ActivityMainBinding.inflate(getLayoutInflater());

    // Assign to the main view.
    setContentView(binding.getRoot());

    // Set the toolbar
    {
      this.setSupportActionBar(binding.toolbar);
    }
    //Adapter
    {
      //Adapter
      this.alertaAdapter = new AlertaAdapter();
      //Adapter
      this.binding.rvAlertasismos.setAdapter(this.alertaAdapter);
      // The layout (ListView)
      this.binding.rvAlertasismos.setLayoutManager(new LinearLayoutManager(this));
      // The separator (line)
      this.binding.rvAlertasismos
          .addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    //Viewmodel
    {
      //Build AlertaViewModel
      this.alertaViewModel = new ViewModelProvider(this).get(AlertaViewModel.class);
      //Observe alertasSismos
      this.alertaViewModel.getAlertas().observe(this,
           alertaSismos ->  this.alertaAdapter.setAlertasSismos(alertaSismos));
      // Observe the exception
      this.alertaViewModel.getException().observe(this,this::showException);
    }

    //refresh
    {
      this.binding.swlRefresh.setOnRefreshListener(() ->{
        log.debug("REFRESHING.....");

        //Run in background
        AsyncTask.execute(() ->{
          //all ok
          final int size = this.alertaViewModel.refresh();
          if(size!=-1){
            //In the UI
            runOnUiThread(()->{
              //hide the loading
              this.binding.swlRefresh.setRefreshing(false);

              //show a message
              Toasty.success(this,"Alertas fetched:" + size
              ,Toast.LENGTH_SHORT,true).show();
            });
          }
        });
      });
    }
  }


  /**
   * Show the exception.
   *
   * @param exception to use.
   */
  private void showException(final Exception exception) {

    // Hide the loading
    this.binding.swlRefresh.setRefreshing(false);

    // Build the message
    final StringBuilder sb = new StringBuilder("Error: ");
    sb.append(exception.getMessage());
    if (exception.getCause() != null) {
      sb.append(", ");
      sb.append(exception.getCause().getMessage());
    }

    Toasty.error(this, sb.toString(), Toast.LENGTH_LONG, true).show();

  }
}
