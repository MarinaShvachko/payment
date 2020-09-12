package com.payment.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Server {
    //принимает оплату от приложения
    // TODO: 12.09.2020   добавить проверку на получаемые данные
    private String hostAddress;
    private int port;
    private String protocol;
}
