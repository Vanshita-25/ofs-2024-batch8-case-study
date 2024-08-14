import read from 'readline-sync';
let text = read.question("Enter text: ");
let number = read.questionInt("Enter number: ");
let password = read.questionNewPassword("Enter password: ")
let email = read.questionEMail("Enter email: ")
console.log(password);
console.log(text);
console.log(number);
console.log(email);
