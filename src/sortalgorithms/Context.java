/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopfınal;

/**
 *
 * @author DELL
 */
public class Context {
    private Strategy strategy;
    
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    
    public void executeStrategy(int [] numbers){
        strategy.sortOperation(numbers);
    }
    
}
