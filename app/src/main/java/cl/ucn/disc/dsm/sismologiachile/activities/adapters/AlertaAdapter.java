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

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cl.ucn.disc.dsm.sismologiachile.databinding.RowAlertasimosBinding;
import cl.ucn.disc.dsm.sismologiachile.model.AlertaSismo;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertaAdapter extends RecyclerView.Adapter<AlertaViewHolder> {

  /**
   * Logger
   */
  private static final Logger log = LoggerFactory.getLogger(AlertaAdapter.class);
  /**
   * Lista AlertaSismo
   */
  private List<AlertaSismo> theAlertas;

  /**
   * Constructor
   */
  public AlertaAdapter(){

    this.theAlertas = new ArrayList<>();

    this.setHasStableIds(true);
  }

  /**
   * Set AlertaSimos
   * @param alerta
   */
  public void setAlertasSismos(final List<AlertaSismo> alerta){
    this.theAlertas = alerta;

    this.notifyDataSetChanged();
  }
  /**
   *
   * @param parent
   * @param viewType
   * @return alertviewHolder
   */
  @NonNull
  @Override
  public AlertaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

    final RowAlertasimosBinding rowAlertasimosBinding = RowAlertasimosBinding.inflate(
        layoutInflater,parent,false);

    final AlertaViewHolder alertaViewHolder = new AlertaViewHolder(rowAlertasimosBinding);

    rowAlertasimosBinding.getRoot().setOnClickListener(view ->{

      final int position = alertaViewHolder.getAdapterPosition();

      final long id = alertaViewHolder.getItemId();
      log.debug("Click! position: {}, id: {}.", position, Long.toHexString(id));

      final AlertaSismo alertaSismo = theAlertas.get(position);

      log.debug("Link: {}.", alertaSismo.getUrl());
      if(alertaSismo.getUrl() !=null){

        parent.getContext().startActivity(
            new Intent(
                Intent.ACTION_VIEW, Uri.parse(alertaSismo.getUrl())
            )
        );
      }
    });
    return alertaViewHolder;
  }

  /**
   * OnBindViewHolder
   * @param holder to use
   * @param position to use
   */
  @Override
  public void onBindViewHolder(@NonNull AlertaViewHolder holder, int position) {
  holder.bind(this.theAlertas.get(position));
  }

  /**
   *
   * @return size
   */
  @Override
  public int getItemCount() {
    return this.theAlertas.size();
  }

  /**
   *
   * @param position to use
   * @return id
   */
  @Override
  public long getItemId(int position){
    return this.theAlertas.get(position).getId();
  }
}
