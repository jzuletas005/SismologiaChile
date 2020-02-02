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
import cl.ucn.disc.dsm.sismologiachile.model.AlertaSismo;
import cl.ucn.disc.dsm.sismologiachile.services.AlertaSismosService;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlertaSismosApiService implements AlertaSismosService {

  /**
   * Logger
   */
  private static final Logger log = LoggerFactory.getLogger(AlertaSismosApiService.class);
  /**
   * Alerta Sismos API
   */
  private final AlertaSismosApi alertaSismosApi;

  /**
   * Constructor
   */
  public AlertaSismosApiService(){
    // Logging with slf4j
    final HttpLoggingInterceptor loggingInterceptor =
        new HttpLoggingInterceptor(log:: debug).setLevel(Level.BODY);

    // Web Client
    final OkHttpClient httpClient = new Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .callTimeout(10, TimeUnit.SECONDS)
        .addNetworkInterceptor(loggingInterceptor)
        .build();

    // https://futurestud.io/tutorials/retrofit-getting-started-and-android-client
    this.alertaSismosApi =  new Retrofit.Builder()
        // The main URL
        .baseUrl(AlertaSismosApi.BASE_URL)
        // JSON to POJO
        .addConverterFactory(GsonConverterFactory.create())
        // Validate the interface
        .validateEagerly(true)
        // The client
        .client(httpClient)
        // Build the Retrofit ..
        .build()
         // .. get the ChileAlerta api.
        .create(AlertaSismosApi.class);
  }

  /**
   * Get Alertas for Call
   * @param theCall to use
   * @return List of AlertaSismos
   */
  private  List<AlertaSismo> getAlertaSimosFromCall(Call<AlertaSismosApiResult> theCall){

    try{
      //get the result from the call
      final Response<AlertaSismosApiResult> response = theCall.execute();
      //UnSuccessful
      if(!response.isSuccessful()){
        //Error
        throw new AlertaSismosApiException(
            "No obtiene alertaSimosResult, code: " + response.code(),
            new HttpException(response)
        );
      }
      final AlertaSismosApiResult theAlertaResult = response.body();

      if(theAlertaResult==null){
        throw new AlertaSismosApiException("alerta null");
      }
      return theAlertaResult.ultimos_sismos_chile;

    }catch (final IOException ex){

      throw new AlertaSismosApiException("No obtiene AlertaSismosResult", ex);
    }
  }

  /**
   * getAlertaSismo
   * @param page_size
   * @return List of AlertaSismo
   */
  @Override
  public List<AlertaSismo> getAlertaSismo(int page_size) {

    final Call<AlertaSismosApiResult> theCall = this.alertaSismosApi.getUltimosSimos("ultimos_sismos","chile");
    return getAlertaSimosFromCall(theCall);
  }

  /**
   * The Exception.
   */
  public static final class AlertaSismosApiException extends RuntimeException {

    public AlertaSismosApiException(final String message) {
      super(message);
    }

    public AlertaSismosApiException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }
}
