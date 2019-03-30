package com.app.mg.connectionlibraryandroid.Methods;

import android.content.Context;

import java.util.List;

public interface IConnectMethods {

    String FindMyIpAddress(Context context);

    List<String> FindServers(Context context, String port);


}
