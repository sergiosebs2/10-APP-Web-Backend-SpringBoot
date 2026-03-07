package com.testTC.testTC.payload;


//Es la clase que define la estructura del JSON de error.



import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor
public class ApiResponse {
    private Date tiempo = new Date();
    private String mensaje;
    private String url;

    public ApiResponse(String mensaje, String url){
        this.mensaje = mensaje;
        this.url = url.replace("uri=","");
    }

}
