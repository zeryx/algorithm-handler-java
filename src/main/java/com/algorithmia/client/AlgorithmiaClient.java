package com.algorithmia;

import com.algorithmia.algo.*;
import com.algorithmia.client.*;
import com.algorithmia.data.*;

/**
 * Instantiate Algorithmia clients for calling algorithms and accessing data
 */
public final class AlgorithmiaClient {
    private HttpClient client;
    /**
     * Instantiate Algorithmia client without credentials
     * This only works for when running the client on top of the Algorithmia platform
     */
    protected AlgorithmiaClient() {}

    /**
     * Instantiate Algorithmia client without Simple Key Auth
     * @param simpleKey an Algorithmia API key with the "sim" prefix
     */
    protected AlgorithmiaClient(Auth auth) {
        this.client = new HttpClient(auth);
    }

    /**
     * Initialize an Algorithm object from this client
     * @param algoUri the algorithm's URI, e.g., algo://user/algoname
     * @return an Algorithm client for the specified algorithm
     */
    public Algorithm algo(String algoUri) {
        return new Algorithm(client, algoUri);
    }

    /**
     * Initialize a DataDirectory object from this client
     * @param path to a data directory, e.g., data://.my/foo
     * @return a DataDirectory client for the specified directory
     */
    public DataDirectory dir(String path) {
        return new DataDirectory(client, path);
    }

    /**
     * Initialize an DataFile object from this client
     * @param path to a data file, e.g., data://.my/foo/bar.txt
     * @return a DataFile client for the specified file
     */
    public DataFile file(String path) {
        return new DataFile(client, path);
    }
}