package com.chromeinfotech.ui.networkoperation;


import com.chromeinfotech.ui.networkoperation.Exception.Emptyuri;
import com.chromeinfotech.ui.networkoperation.Exception.InvalidUri;
import com.chromeinfotech.utils.Utils;

/**
 * Created by user on 28/2/17.
 */

public class NetworkOperation {

    /**
     * call from ExceptionActivity and check uri is valid or not or uri is empty  and throw exception
     * @param uri
     * @throws InvalidUri
     * @throws Emptyuri
     */
    public void doRequest(String uri)throws InvalidUri, Emptyuri {
        Utils.printLog("NetworkOperation","inside doRequest");

        if(uri.isEmpty()) {
            Utils.printLog("NetworkOperation","inside if");
            throw new Emptyuri("uri is empty");
        }

        if(uri.startsWith("http") || uri.startsWith("https")) {
            Utils.printLog("NetworkOperation","uri is valid");

        }
        else{
            throw new InvalidUri("uri is Invalid");
        }
    }

}


