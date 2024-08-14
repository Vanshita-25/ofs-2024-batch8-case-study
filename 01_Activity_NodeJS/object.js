import { Employee } from "./employee.js";
import fs from 'fs';
import read from 'readline-sync';

let id = read.questionInt("Enter id: ");
let name = read.question("Enter name: ");
let salary = read.questionInt("Enter salary: ");
let employee = new Employee(id, name, salary);

let employees = [];

if (fs.existsSync('employees.json')) {
  let existingData = fs.readFileSync('employees.json');
  employees = JSON.parse(existingData);
}

employees.push(employee);

fs.writeFileSync('employees.json', JSON.stringify(employees));

employee.display();