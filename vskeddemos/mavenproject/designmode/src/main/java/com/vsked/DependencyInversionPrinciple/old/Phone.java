package com.vsked.DependencyInversionPrinciple.old;

public class Phone {
    public void openAppQQ(QQ qq){
        qq.open();
    }
    public void openAppTaoBao(TaoBao taoBao){
        taoBao.open();
    }
}
