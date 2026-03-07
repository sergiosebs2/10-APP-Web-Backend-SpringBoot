package com.testTC.testTC.payload;


//Es la clase que define la estructura del JSON de error.



import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data @NoArgsConstructor
public class ApiResponse {
    private LocalDateTime detalleTiempo = LocalDateTime.now();
    private String descripcion;
    private String url;

    public ApiResponse(String descripcion, String url){
        this.descripcion = descripcion;
        this.url = url.replace("uri=","");
    }

}

