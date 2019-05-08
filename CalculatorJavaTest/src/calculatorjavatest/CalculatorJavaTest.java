/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorjavatest;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author Muduck
 */
public class CalculatorJavaTest {

    /**
     * @param args the command line arguments
     */
    public static int IsZnakWP(char S) {
	if (S == '^') {
		return 4;
	}
	else if (S == '*' || S == '/') {
		return 3;
	}
	else if (S == '-' || S == '+') {
		return 2;
	}
	else if (S == '(' || S == ')') {
		return 1;
	}
	else return 0;
        }
  public static void Calculator(String in) {
	Vector out=new Vector();
	Vector stack=new Vector();
	StringBuffer buffer=new StringBuffer();  //размер по умолчанию 16
        int in_counter=0;
	Vector key_buf=new Vector();
	if (in.charAt(in_counter) == '-') { out.addElement("0"); }//Для поддержки выражений вида -3+2
	while (in_counter!=in.length()-1) {
		if (0==IsZnakWP(in.charAt(in_counter))) {
			key_buf.addElement(in.charAt(in_counter));
			in_counter++;
			continue;
		}
		else 
		{
			if (!key_buf.isEmpty()) {
				for (int i = 0; i < key_buf.size(); i++) {
					buffer.append(key_buf.elementAt(i));
					System.out.println("Скинул цифру из буфера в аут");
                                        System.out.println("Буффер = "+buffer);
				}
				for (int i = key_buf.size(); i >0 ; i--) {
					key_buf.remove(key_buf.size()-1);
				}
				out.addElement(buffer);
			    //buffer[0] = '\0'; надо обнулить весь массив, пока что решил юзать memset 
				buffer.delete(0,buffer.length());
				System.out.println("Обнуленный буффер: "+ buffer);
			}
			if (stack.isEmpty()) { stack.addElement(in.charAt(in_counter)); in_counter++; continue; }
			if (in.charAt(in_counter) == '(') { //ТУТ НАДО ПРИДУМАТЬ ЧТО ТО ДЛЯ ВЫРАЖЕНИЙ ТИПА 2+3-(-2+1)
				in_counter++;
				if(in.charAt(in_counter)=='-'){ out.addElement("0"); }//Для поддержки выражений вида 2+3-(-2+1)
				in_counter--;
				stack.addElement(in.charAt(in_counter)); 
				in_counter++; 
				continue;
			}
			if (in.charAt(in_counter) == ')') {
				do {
					buffer.append(stack.elementAt(stack.size() - 1));
					stack.remove(stack.size()-1);
					out.addElement(buffer);
					//buffer[0] = '\0';
				        buffer.delete(0,buffer.length());
				} while (stack.elementAt(stack.size() - 1) != "(");
				stack.remove(stack.size()-1);//удаляем ( из стека
				in_counter++;
				continue;
			}
			while (IsZnakWP(in.charAt(in_counter)) <= IsZnakWP((char)stack.elementAt(stack.size() - 1))) {
				buffer.append(stack.elementAt(stack.size() - 1));
				stack.remove(stack.size()-1);
			        out.addElement(buffer);
				//buffer[0] = '\0';
				buffer.delete(0,buffer.length());
			
			}
			stack.addElement(in.charAt(in_counter));
			in_counter++;
		}
	}
	/////////////////////////////////// БЕЗ ЭТОЙ ЧАСТИ У МЕНЯ ПРОБЛЕМА С ПОСЛЕДНИМ СИМВОЛОМ(если он цифра)
	//ОН ОСТАЕТСЯ В key_back 
	//и не выходит в out(т.к. после его помещения в буффер key_buf идет continue) пока решил так
	if (!key_buf.isEmpty()) {
		buffer.append(key_buf.elementAt(0));
		out.addElement(buffer);
		//buffer[0] = '\0';
		buffer.delete(0,buffer.length());
		key_buf.remove(key_buf.size()-1);
	}
	///////////////////////////////////
	while (!stack.isEmpty()) {
                buffer.append(stack.elementAt(stack.size() - 1));
		stack.remove(stack.size()-1);
		out.addElement(buffer);
		//buffer[0] = '\0';
		buffer.delete(0,buffer.length());
	}
	//Проверка корректности постфиксной записи
	for (int i = 0; i < out.size(); i++) {
		System.out.println("out["+i+"]= "+ out.elementAt(i));
	}
	System.out.println("В виде строки: ");
	for (int i = 0; i < out.size(); i++) {
		System.out.print(out.elementAt(i));
	}


	Vector result = new Vector();
        double a,b,c;
	StringBuffer temp=new StringBuffer();
	for (int i = 0; i < out.size(); i++) {
		if (out.elementAt(i) == "-") {
			a = (double)result.elementAt(result.size() - 2);
			b = (double)result.elementAt(result.size() - 1);
			c = a - b;
			result.remove(result.size()-1);
			result.remove(result.size()-1);
			result.addElement(c);
			continue;
		}
		if (out.elementAt(i) == "+") {
			a = (double)result.elementAt(result.size() - 2);
			b = (double)result.elementAt(result.size() - 1);
			c = a + b;
			result.remove(result.size()-1);
			result.remove(result.size()-1);
			result.addElement(c);
			continue;
		}
		if (out.elementAt(i) == "/") {
			a = (double)result.elementAt(result.size() - 2);
			b = (double)result.elementAt(result.size() - 1);
			c = a / b;
			result.remove(result.size()-1);
			result.remove(result.size()-1);
			result.addElement(c);
			continue;
		}
		if (out.elementAt(i) == "*") {
			a = (double)result.elementAt(result.size() - 2);
			b = (double)result.elementAt(result.size() - 1);
			c = a * b;
			result.remove(result.size()-1);
			result.remove(result.size()-1);
			result.addElement(c);
			continue;
		}
		if (out.elementAt(i) == "^") {
			a = (double)result.elementAt(result.size() - 2);
			b = (double)result.elementAt(result.size() - 1);
			c = Math.pow(a, b);
			result.remove(result.size()-1);
			result.remove(result.size()-1);
			result.addElement(c);
			continue;
		}
	temp =(StringBuffer)out.elementAt(i);
	c = Double.valueOf(temp);//////////!!!!!!!!!!!!!!!!!!!!!!!!!!!
	result.addElement(c);
	}
	System.out.println("Результат вычислений: " + result.elementAt(0));
}
    public static void main(String[] args) {
        // TODO code application logic here
	    System.out.println("Правила ввода!\nНе писать 3+(-2), пиши 3-2 сразу");
	    System.out.println("Введи строку, я стараюсь учитывать все варианты и просчитывать все опасности, но я плох в математике.");
	    Scanner in=new Scanner(System.in);
        String enter=in.nextLine();
        System.out.println("Ты ввел : "+enter);
	    //char in[] = "3+2-(-2+3)";
	    Calculator(enter);
    }
    
}
