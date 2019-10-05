package com.unlu.tp2;

public class Cliente
{
    private int id;
    private String descr;

    /**
     * Constructor for objects of class Cliente
     */
    public Cliente() {
        this(0,"sin nombre");
    }
    public Cliente(int i) {
        this(i,"sin nombre");
    }
    public Cliente(int i,String d) {
        setId(i);setDescr(d);
    }
    
    //SETTERS
    public void setId(int i) { id = i; }
    public void setDescr(String d) { descr = d; }
    //GETTERS
    public int getId() { return id; }
    public String getDescr() { return descr; }

    @Override
    public String toString() {
        return "[cliente id:"+getId()+", descr:"+getDescr()+"]";
    }
}
