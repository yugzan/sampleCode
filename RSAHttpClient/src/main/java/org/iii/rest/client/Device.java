package org.iii.rest.client;

public class Device {
  private String DEVICE_ID;
  private String TYPE;
  private String CIRCUIT;
  private String FEED_ID;
  private String API_KEY;

  public Device() {

  }

  public String getDEVICE_ID() {
    return DEVICE_ID;
  }

  public void setDEVICE_ID(String dEVICE_ID) {
    DEVICE_ID = dEVICE_ID;
  }

  public String getTYPE() {
    return TYPE;
  }

  public void setTYPE(String tYPE) {
    TYPE = tYPE;
  }

  public String getCIRCUIT() {
    return CIRCUIT;
  }

  public void setCIRCUIT(String cIRCUIT) {
    CIRCUIT = cIRCUIT;
  }

  public String getFEED_ID() {
    return FEED_ID;
  }

  public void setFEED_ID(String feed_ID) {
    FEED_ID = feed_ID;
  }

  public String getAPI_KEY() {
    return API_KEY;
  }

  public void setAPI_KEY(String aPI_KEY) {
    API_KEY = aPI_KEY;
  }

}
