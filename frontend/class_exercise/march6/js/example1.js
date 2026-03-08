let num1 = Number(prompt("Enter the first number:"));
let num2 = Number(prompt("Enter the second number:"));
let operator = prompt("Enter the operator (+, -, *, /):");

let res;
switch (operator) {
    case "+":
        res = num1 + num2;
        break;
    case "-":
        res = num1 - num2;
        break;
    case "*":
        res = num1 * num2;
        break;
    case "/":
        if (num2 !== 0) {
            res = num1 / num2;
        } else {
            res = "Error: Division by zero";
        }
        break;
    default:
        res = "Invalid operator";
}

alert(`Result: ${res}`);

