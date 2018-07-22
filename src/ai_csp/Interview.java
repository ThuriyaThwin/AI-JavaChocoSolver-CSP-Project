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
public class Interview {
    public static void main(String[] args){
         Model model = new Model("Interviews");
         int count_solutions = 0;
// 2. Create variables
IntVar ali = model.intVar("Ali", 8,11); 
IntVar bob = model.intVar("Bob", 8, 11); 
IntVar cam = model.intVar("Cam",8,11);
IntVar dan = model.intVar("Dan",8,11);
// 3. Post constraints

model.arithm(ali, "!=", 9).post(); 
model.arithm(dan,"!=", 9).post(); 
model.arithm(bob,"<",10).post();
model.arithm(cam,"<", 10).post();
model.allDifferent(ali,dan,bob,cam).post();
// 4. Solve the problem
Solver solver = model.getSolver();
while(solver.solve()){
// 5. Print the solution
count_solutions++;
System.out.println(ali); 
System.out.println(bob); 
System.out.println(cam);
System.out.println(dan);
}
System.out.println("The total number of solutions to this problem is/are : " + count_solutions);
    }
}
