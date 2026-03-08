let products = new Map();
function addProducts(){
    let name = document.getElementById("pname").value
    let price = document.getElementById("price").value

    console.log(name)
    products.set(name,price)
    alert("Product successfully added")
}

function showProducts(){
    let ul_List = document.getElementById("prodList")
    ul_List.innerHTML=''

    products.forEach(function(price,name){
        let li = document.createElement("li")
            li.innerText = name + ' = ' +  price
            ul_List.appendChild(li)
    })
}