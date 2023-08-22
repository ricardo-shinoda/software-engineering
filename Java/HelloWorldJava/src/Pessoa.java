/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ricardo
 */
public class Pessoa {
    String sexo;
    String corPele;
    int peso;
    
    public void comer()
    {
        System.out.println("Estou com fome!");
    }
    
    public void sono()
    {
        System.out.println("Estou com sono");
    }
    
    public void estudar()
    {
        System.out.println("O/a estudante vai estudar");
    }
    
    private void correr()
    {
        System.out.println("Necessário correr para se exercitar");
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        
        pessoa.comer();
        pessoa.sono();
        pessoa.estudar();
        
        // You cannot call correr() directly from here because it's a private method.
        
        // To call correr(), you can use Java Reflection. Here's an example:
        try {
            // Get a reference to the correr() method using reflection
            java.lang.reflect.Method method = pessoa.getClass().getDeclaredMethod("correr");
            
            // Set the method accessible, even though it's private
            method.setAccessible(true);
            
            // Call the correr() method
            method.invoke(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
