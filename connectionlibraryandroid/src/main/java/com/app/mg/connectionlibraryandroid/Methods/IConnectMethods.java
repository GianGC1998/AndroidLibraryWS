package com.app.mg.connectionlibraryandroid.Methods;

import android.content.Context;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

public interface IConnectMethods {

    String FindMyIpAddress(Context context);

    List<String> FindServers(String myIpAddress, String port);

    InetSocketAddress GetISocketAddres(Context context, String port);

    URI GetUriServer(String ipAddress,  String port);
}
