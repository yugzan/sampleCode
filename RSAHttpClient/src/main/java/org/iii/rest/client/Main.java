package org.iii.rest.client;

import java.util.List;

import com.google.gson.Gson;

public class Main {
    public static String id = "intrauser";
    public static String pw = "EvUgljM^t1M&*#TV";
    public static String loginUrl = "http://iiimeterweb.azurewebsites.net/api/Intra/login";
    public static String getDeviceListUrl = "http://iiimeterweb.azurewebsites.net/api/Intra/getDeviceList";

    public static void main(String[] args) {

        // get access token
        LoginRequest loginRequest = new LoginRequest(id, pw);
        String jsonToken = new Client().post(loginUrl, loginRequest);
        LoginResponse loginResponse = new Gson().fromJson(jsonToken, LoginResponse.class);

        // get device list
        GetDeviceListRequest deviceListRequest = new GetDeviceListRequest(loginResponse.getToken(),
                1, 30);
        String jsonDeviceList = new Client().post(getDeviceListUrl, deviceListRequest);

        GetDeviceListResponse getDeviceListResponse = new Gson().fromJson(jsonDeviceList,
                GetDeviceListResponse.class);

        List<Device> deviceList = getDeviceListResponse.getDeviceList();

        System.out.println("{");
        System.out.println("  \"DeviceList\":[");
        for (Device device : deviceList) {
            System.out.println("  {");
            System.out.println("    \"DEVICE_ID\":" + "\"" + device.getDEVICE_ID() + "\",");
            System.out.println("    \"TYPE\":" + "\"" + device.getTYPE() + "\",");
            System.out.println("    \"CIRCUIT\":" + "\"" + device.getCIRCUIT() + "\",");
            System.out.println("    \"Feed_ID\":" + "\"" + device.getFEED_ID() + "\",");
            System.out.println("    \"API_KEY\":" + "\"" + device.getAPI_KEY() + "\"");
            System.out.println("  },");
        }
        System.out.println("],");
        System.out.println("  \"records\":" + "\"" + getDeviceListResponse.getRecords() + "\",");
        System.out.println("  \"total\":" + "\"" + getDeviceListResponse.getTotal() + "\"");
        System.out.println("}");
    }

}
