
let cboard = new Array(8);
for(let i = 0; i < cboard.length; i++) {
    cboard[i] = new Array(8);
}
for(let j = 0; j < cboard.length; j++) {
    for(let k = 0; k < cboard.length; k++) {
        cboard[j][k] = 0;
    }
}


function isPossible(qlist, row, col) {
    for(let i = 0; i < col; i++) {
        if(qlist[row][i] == 1) {
            return false;
        }
    }
    let j = row - 1;
    let k = col - 1;
    while(j >= 0 && k >= 0) {
        if(qlist[j][k] == 1) {
            return false;
        }
        j--;
        k--;
    }
    j = row + 1;
    k = col - 1;
    while(j < qlist.length && k >= 0) {
        if(qlist[j][k] == 1) {
            return false;
        }
        j++;
        k--;
    }
    return true;
}

function queen(qlist, col) {
    if(col >= qlist.length) {
        return true;
    }
    for(let i = 0; i < qlist.length; i++) {
        if(isPossible(qlist, i, col)) {
            qlist[i][col] = 1;
            if(queen(qlist, col + 1)) {
                return true;
            }
            qlist[i][col] = 0;
        }
    }
    return false;
}

queen(cboard, 0);


let cols = {0:"A", 1:"B", 2:"C", 3:"D", 4:"E", 5:"F", 6:"G", 7:"H"}
let table = document.createElement("table");
table.className = "board";
for (let i = 1; i < 9; i++) {
    let tr = document.createElement('tr');
    tr.dataset.line = i
    for (let j = 1; j < 9; j++) {
        let td = document.createElement('td');
        td.dataset.col = cols[j-1];
        td.dataset.line = i;
        td.className = (i%2 === j%2) ? "white square" : "black square";
        if(cboard[i - 1][j - 1] === 1) {
            
            td.innerHTML = "<img class='queen' src='image.png' width='60' height='60'>";
        }
        
        tr.appendChild(td);
    }
    table.appendChild(tr);
}
document.querySelector("div").appendChild(table);










