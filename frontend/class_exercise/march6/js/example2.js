
let res;

function add() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    res = num1 + num2;
    document.getElementById("result").innerText = "Sum: " + res;
}

function subtract() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    res = num1 - num2;
    document.getElementById("result").innerText = "Difference: " + res;

}

function multiply(a, b) {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    res = a * b;
    document.getElementById("result").innerText = "Product" + res;
}

function divide() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    res = num1 / num2;
    document.getElementById("result").innerText = "Quotient" + res;

}
