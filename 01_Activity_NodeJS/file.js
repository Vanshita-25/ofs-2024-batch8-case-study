import read from "readline-sync";
import fs from 'fs';

let text = read.question("Enter text: ");
//This will reqrite so to retain old content and add new line
fs.writeFileSync("demo.text",text+"\n",{flag:"a+"});

console.log("Done file writing");
//ReadFile sync return buffer data that must be converted to json
let fileData = fs.readFileSync("demo.text");
console.log(fileData.toString());