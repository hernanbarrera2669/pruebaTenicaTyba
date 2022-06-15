package com.tyba.utils;

import net.serenitybdd.core.time.InternalSystemClock;

public class Esperas {

    public void enSegundos(int segundos){
        new InternalSystemClock().pauseFor((long)segundos*1000);
   }
}
