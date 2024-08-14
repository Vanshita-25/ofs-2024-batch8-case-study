//if u export then can be impoerted in another js file
export class Employee{
    //Constructor is keyword in js
    constructor(id,name,salary){
        this.id =id;
        this.name=name;
        this.salary =salary;
    }
    display(){
        console.log(`Id=${this.id},Name=${this.name},Salary=${this.salary}`);
    }
}