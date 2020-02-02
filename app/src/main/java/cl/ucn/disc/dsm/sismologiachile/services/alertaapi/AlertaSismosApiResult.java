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
package cl.ucn.disc.dsm.sismologiachile.services.alertaapi;

import cl.ucn.disc.dsm.sismologiachile.model.AlertaSismo;
import java.util.ArrayList;
import java.util.List;

public class AlertaSismosApiResult {

  public Metadata metadata;
  public List<AlertaSismo> ultimos_sismos_chile = new ArrayList<AlertaSismo>();
  //Error que tuve en los proyectos anteriores a es fue solucionado en conjunto a Gonzalo Nieto

}
