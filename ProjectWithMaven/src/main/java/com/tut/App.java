package com.tut;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started" );
         Configuration cfg = new Configuration();
         cfg.configure("com/tut/hibernate.cfg.xml");
         Sessionfactory factory = cfg.buildSesssionFactory();
         System.out.println(factory);
    }
}