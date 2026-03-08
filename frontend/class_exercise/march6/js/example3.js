let students = []

function addStudent() {
    let name = document.getElementById("name").value
    let marks = Number(document.getElementById("marks").value)
    let attendance = document.querySelector('input[name="attendance"]:checked').value
    console.log(attendance)

    students.push({ name: name, marks: marks, attendance: attendance })
    console.log(students)

    displayStudents()
}

function calculateStats() {
    sum = 0;
    max = Number.MIN_SAFE_INTEGER;
    min = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i < students.length; i++) {
        sum += students[i].marks;
        if (students[i].marks > max) {
            max = students[i].marks;
        }
        if (students[i].marks < min) {
            min = students[i].marks;
        }

    }
    document.getElementById("totalMarks").innerText = "Total marks = " + sum;
    document.getElementById("avgMarks").innerText = "Average marks = " + sum / students.length;
    document.getElementById("maxMarks").innerText = "Max marks = " + max;
    document.getElementById("minMarks").innerText = "Min Marks = " + min;

    console.log(attendance)
    
}

function displayStudents() {
    let list = document.getElementById("studentList")
    list.innerHTML = ""
    for (let i = 0; i < students.length; i++) {
        let li = document.createElement("li")
        li.innerText = students[i].name + " : " + students[i].marks + " " +  students[i].attendance;
        list.appendChild(li)
    }
}