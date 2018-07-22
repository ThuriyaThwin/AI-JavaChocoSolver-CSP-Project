/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_csp;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;


/**
 *
 * @author Ayesh
 */
public class sculptures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 1. Create a Model
        Model model = new Model("Sculptures");
        int  count_solutions = 0;
// 2. Create variables
IntVar swan = model.intVar("S", 1, 3); 
IntVar lion = model.intVar("L", 1, 3); 
IntVar marblepyramid = model.intVar("P",1,3);
// 3. Post constraints

model.arithm(swan, "!=", 1).post(); 
model.arithm(swan,"!=",lion.getValue() + 1).post(); 
model.arithm(swan,"!=",lion.getValue() - 1).post();
model.arithm(lion,"!=", swan.getValue() + 1).post();
model.arithm(lion, "!=", swan.getValue() - 1).post();
model.allDifferent(swan,lion,marblepyramid).post();
// 4. Solve the problem
Solver solver = model.getSolver();
while(solver.solve()){
count_solutions++;
// 5. Print the solution
System.out.println(swan); 
System.out.println(lion); 
System.out.println(marblepyramid);
}
System.out.println("The total number of solutions to this problem is/are : " + count_solutions);
    }
    
}
