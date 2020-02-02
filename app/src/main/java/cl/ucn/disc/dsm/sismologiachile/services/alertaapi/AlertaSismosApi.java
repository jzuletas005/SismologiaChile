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

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlertaSismosApi {

  /**
   * Alerta Sismos API
   */
  String BASE_URL = "https://chilealerta.com/api/query/";

  /**
   * Get JSON
   * @param select to use
   * @param country to use
   * @return
   */
  @GET("?user=jzuletas")
  Call<AlertaSismosApiResult> getUltimosSimos(
      @Query("select") final String select,
      @Query("country") final String country);
}
