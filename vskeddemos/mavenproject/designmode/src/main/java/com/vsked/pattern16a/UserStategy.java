package com.vsked.pattern16a;

/**
 *  this is 使用离间计的地方
 *
 */
public class UserStategy {
    private StrategyInterface strategyInterface;
    
    public UserStategy(StrategyInterface strategyInterface){
        this.strategyInterface=strategyInterface;
    }
    
    public void action(){
        this.strategyInterface.excit();
    }
}
