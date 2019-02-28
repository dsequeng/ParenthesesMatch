package parenthesesmatch;

import java.util.Stack;

/**
 *
 * @author dany
 */
public class ParenthesesMatch {

    
    public static void main(String[] args) {
        System.out.println("(a[0] + b[2c[6]]){24 + 53} passed: " + parensMatch("(a[0] + b[2c[6]]){24 + 53}"));
        System.out.println("f(e(d)) passed: " + parensMatch("f(e(d))"));
        System.out.println("((b) passed: " + !parensMatch("((b)"));
        System.out.println("(empty) passed: " + parensMatch("(empty)"));
        System.out.println("([)] passed: " + !parensMatch("([)]"));
        System.out.println(" passed: " + parensMatch("     "));
        System.out.println("passed: " + parensMatch(""));
        
    }
    
    public static boolean parensMatch(String formula)
    {
        //
        Stack<Character> pila = new Stack<Character>();        
        char[] caracteres = formula.toCharArray();
        for(int i=0; i<formula.length(); i++)
        {
            if(caracteres[i] == '(')
            {
                pila.push(caracteres[i]);
            }
            if(caracteres[i] == '[')
            {
                pila.push(caracteres[i]);
            }
            if(caracteres[i] == '{')
            {
                pila.push(caracteres[i]);
            }
            if(caracteres[i] == ')')
            {
                if(pila.empty()==true)
                {
                    return false;
                }
                else
                {
                    if(pila.peek()=='(')
                    {
                        pila.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            
            if(caracteres[i] == ']')
            {
                if(pila.empty()==true)
                {
                    return false;
                }
                else
                {
                    if(pila.peek()=='[')
                    {
                        pila.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            
            if(caracteres[i] == '}')
            {
                if(pila.empty()==true)
                {
                    return false;
                }
                else
                {
                    if(pila.peek()=='{')
                    {
                        pila.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            
        }
        return pila.empty();
    }
    
    
}