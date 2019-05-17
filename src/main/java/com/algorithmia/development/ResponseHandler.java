package com.algorithmia.development;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

final class ResponseHandler {

    private String FIFOPATH = "/tmp/algoout";

    private PrintStream output;

    ResponseHandler() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.FIFOPATH, true);
            output = new PrintStream(fileOutputStream, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    <OUTPUT> void writeToPipe(OUTPUT outputObject) {
        Response response = new Response(outputObject);
        String serialized = response.getJsonOutput();
        this.output.println(serialized);
        this.output.flush();
    }

    <ERRORTYPE extends RuntimeException> void writeErrorToPipe(ERRORTYPE e) {
        SerializableException<ERRORTYPE> exception = new SerializableException<>(e);
        String serialized = exception.getJsonOutput();
        this.output.println(serialized);
        this.output.flush();
    }
}