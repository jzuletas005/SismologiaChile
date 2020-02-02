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

import androidx.recyclerview.widget.RecyclerView;
import cl.ucn.disc.dsm.sismologiachile.databinding.RowAlertasimosBinding;
import cl.ucn.disc.dsm.sismologiachile.model.AlertaSismo;
import java.util.Date;
import org.ocpsoft.prettytime.PrettyTime;
import org.threeten.bp.DateTimeUtils;

public class AlertaViewHolder extends RecyclerView.ViewHolder {
  /**
   * Bindings
   */
  private final RowAlertasimosBinding binding;
  /**
   * The Date formatter
   */
  private static final PrettyTime PRETTY_TIME = new PrettyTime();

  /**
   * Cosntructor
   * @param rowAlertasimosBinding to use.
   */
  public AlertaViewHolder(RowAlertasimosBinding rowAlertasimosBinding) {
    super(rowAlertasimosBinding.getRoot());
    this.binding= rowAlertasimosBinding;
  }

  /**
   * Bind to alertas
   * @param alertaSismo
   */
  public void bind(final AlertaSismo alertaSismo){ //TODO inicializar antes de desplegar

    final String latitud = String.valueOf(alertaSismo.getLatitude());
    final String longitud = String.valueOf(alertaSismo.getLongitude());
    final String escala = String.valueOf(alertaSismo.getScale());
    final String profundidad = String.valueOf(alertaSismo.getDepth());
    final String fecha = String.valueOf(alertaSismo.getLocalTime());
    final String fuente = String.valueOf(alertaSismo.getSource());


    //Cabezas
    this.binding.tvLatitudTitle.setText("Latitud");
    this.binding.tvLongitudTitle.setText("Longitud");
    this.binding.tvProfundidadTitle.setText("Profundidad");

    //Datos
    this.binding.tvMagnitud.setText(alertaSismo.getMagnitude().toString());
    this.binding.tvReferencia.setText(alertaSismo.getReference());
    this.binding.tvFecha.setText(new StringBuilder().append("Fecha : ")
        .append(fecha).toString());
    this.binding.tvLatitud.setText(latitud);
    this.binding.tvLongitud.setText(longitud);
    this.binding.tvProfundidad.setText(profundidad);
    this.binding.tvEscala.setText(new StringBuilder().append("Escala : ")
        .append(escala).toString());
    this.binding.tvRecurso.setText(new StringBuilder().append("Fuente : ")
        .append(fuente).toString());

  }
}
