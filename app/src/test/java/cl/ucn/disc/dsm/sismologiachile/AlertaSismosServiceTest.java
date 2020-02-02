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
package cl.ucn.disc.dsm.sismologiachile;

import cl.ucn.disc.dsm.sismologiachile.model.AlertaSismo;
import cl.ucn.disc.dsm.sismologiachile.services.AlertaSismosService;
import cl.ucn.disc.dsm.sismologiachile.services.alertaapi.AlertaSismosApiService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AlertaSismosServiceTest {

  /**
   * Logger
   */
  private static final Logger log = LoggerFactory.getLogger(AlertaSismosService.class);

  @Test
  public void testgetAlertaSismosApi() {
    log.debug("Testing the SismosApiService, requesting Alerta Sismos");

    final int size = 20;

    //AlertaSismos service
    final AlertaSismosService alertaSismosService = new AlertaSismosApiService();

    //List of AlertaSismos
    final List<AlertaSismo> alertaSismos = alertaSismosService.getAlertaSismo(size);

    Assertions.assertNotNull(alertaSismos);

    for(final AlertaSismo alertaSismo: alertaSismos){
     log.debug("AlertaSismo {}.", alertaSismo);
    }
    log.debug("Done.");
  }
}