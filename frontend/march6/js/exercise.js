function calculateSalary(){
    let id = document.getElementById("empID").value;
    let name = document.getElementById("empName").value;

    let salary = Number(document.getElementById("empSalary").value);
    let rate = Number(document.getElementById("incrementRate").value);
    let incrementedSalary = salary * rate;

    document.getElementById("displayEmpID").innerText = "Emp Id:" + id;
    document.getElementById("displayEmpName").innerText = "Emp Name:" + name;
    document.getElementById("displayEmpSalary").innerText = "Incremented Salary is:" + incrementedSalary;

}