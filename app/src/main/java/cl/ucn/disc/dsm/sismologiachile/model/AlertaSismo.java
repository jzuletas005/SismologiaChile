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
package cl.ucn.disc.dsm.sismologiachile.model;

public class AlertaSismo {

  /**
   * The State.
   */
  public Integer state;
  /**
   * The UTC Time.
   */
  public String utcTime;
  /**
   * The Local Time.
   */
  public String local_time;
  /**
   * Chilean Time.
   */
  public String chileanTime;
  /**
   * The Reference.
   */
  public String reference;
  /**
   * The Magnitude.
   */
  public Float magnitude;
  /**
   * The Scale.
   */
  public String scale;
  /**
   * The Latitude.
   */
  public Float latitude;
  /**
   * The longitude.
   */
  public Float longitude;
  /**
   * The Depth.
   */
  public Float depth;
  /**
   * The Id.
   */
  public Long id;
  /**
   * The URL.
   */
  public String url;
  /**
   * The Source.
   */
  public String source;

  /**
   * Constructor
   * @param state -> estado de la alerta
   * @param utcTime -> hora de la alerta fortmato UTC
   * @param localTime -> hora local de la alerta
   * @param chileanTime -> hora de la alerta en chile
   * @param reference -> referencia del sismo
   * @param magnitude -> magnitud del sismo
   * @param scale -> escala del sismo
   * @param latitude -> latitud (ubicacion) del sismo
   * @param longitude -> longitud (ubicacion) del sismo
   * @param depth -> profundidad del sismo
   * @param id -> identificacion de la alerta
   * @param url -> url de la informacion del sismo
   * @param source -> fuente de la informacion del sismo
   */
  public AlertaSismo(Integer state, String utcTime, String local_time, String chileanTime,
      String reference, Float magnitude, String scale, Float latitude, Float longitude,
      Float depth, Long id, String url, String source) {
    this.state = state;
    this.utcTime = utcTime;
    this.local_time = local_time;
    this.chileanTime = chileanTime;
    this.reference = reference;
    this.magnitude = magnitude;
    this.scale = scale;
    this.latitude = latitude;
    this.longitude = longitude;
    this.depth = depth;
    this.id = id;
    this.url = url;
    this.source = source;
  }

  /**
   * Get the State.
   * @return state.
   */
  public Integer getState() {
    return state;
  }
  /**
   *Get the UTC time.
   * @return utctime.
   */
  public String getUtcTime() {
    return utcTime;
  }
  /**
   * Get the Local Time.
   * @return localtime.
   */
  public String getLocalTime() { return local_time; }
  /**
   * Get the Chilean time.
   * @return chileantime.
   */
  public String getChileanTime() {
    return chileanTime;
  }
  /**
   * Get the Reference.
   * @return the reference.
   */
  public String getReference() {
    return reference;
  }
  /**
   * Get the Magnitude.
   * @return magnitude.
   */
  public Float getMagnitude() {
    return magnitude;
  }
  /**
   * Get the Scale.
   * @return scale.
   */
  public String getScale() {
    return scale;
  }
  /**
   * Get the Latitude.
   * @return latitude.
   */
  public Float getLatitude() {
    return latitude;
  }
  /**
   * Get the Longitude.
   * @return longitude.
   */
  public Float getLongitude() {
    return longitude;
  }
  /**
   * Get the Depth.
   * @return depth.
   */
  public Float getDepth() {
    return depth;
  }
  /**
   * Get the Id.
   * @return id.
   */
  public Long getId() {
    return id;
  }
  /**
   * Get the URL.
   * @return url.
   */
  public String getUrl() {
    return url;
  }
  /**
   * Get the Source.
   * @return source.
   */
  public String getSource() {
    return source;
  }
}
