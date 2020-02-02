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
package cl.ucn.disc.dsm.sismologiachile.activities.adapters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import cl.ucn.disc.dsm.sismologiachile.model.AlertaSismo;
import cl.ucn.disc.dsm.sismologiachile.services.AlertaSismosService;
import cl.ucn.disc.dsm.sismologiachile.services.alertaapi.AlertaSismosApiService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

public class AlertaViewModel extends ViewModel {

  /**
   * Logger
   */
  private static final Logger log = LoggerFactory.getLogger(AlertaViewModel.class);
  /**
   * MutableLiveData to List AlertaSimo
   */
  private final MutableLiveData<List<AlertaSismo>> theAlerta = new MutableLiveData<>();
  /**
   * MutableLiveData to Exception
   */
  private final MutableLiveData<Exception> theException = new MutableLiveData<>();
  /**
   * AlertaSismosService
   */
  private AlertaSismosService alertaSismosService = new AlertaSismosApiService();
  /**
   * Tamanio page
   */
  private static final int PAGE_SIZE=10;

  /**
   * LiveData to List AlertaSimo
   * @return theAlerta = MutableLiveData
   */
  public LiveData<List<AlertaSismo>> getAlertas(){return this.theAlerta;}

  /**
   * LiveData to Exception
   * @return theException = MutableLiveData
   */
  public LiveData<Exception> getException() {return this.theException;}

  /**
   * refresh
   * @return size or -1 check error
   */
  public int refresh(){

    try {

      final List<AlertaSismo> alertaSismos = this.alertaSismosService.getAlertaSismo(PAGE_SIZE);

      this.theAlerta.postValue(alertaSismos);

      return alertaSismos.size();

    }catch (final Exception ex) {

      log.error("Error", ex);

      // 2. Set the exception
      this.theException.postValue(ex);

      // 3. All error!
      return -1;
    }
  }
}
