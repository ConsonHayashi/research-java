// 使用ES6/7的语法，因为早期版本的语法和typescript的差别太多，增加了记忆负担，
// 而且变量提升和回调函数内部this指针的特性与其他语言不同，略显另类。
// 使用ES6/7的语法规避上述问题


const add = (num1, num2) => {
    return num1 + num2;
}

const sub = (num1, num2) => {
    return num1 - num2;
}

const mul = (num1, num2) => {
    return num1 * num2;
}

const div = (num1, num2) => {
    if(num2 == 0 ) {
        console.log("零不能作为除数")
        return null;
    }
    return num1 / num2;
}

const calculate = (num1, num2, operationStr) => {
    if(typeof num1 !== "number" || typeof num2 !== "number", typeof operationStr !== "string"){
        console.log("参数类型非法");
        return;
    }
    switch(operationStr) {
        case "+":
            return add(num1, num2);
        case "-":
            return sub(num1, num2);
        case "*":
            return mul(num1, num2);
        case "/":
            return div(num1, num2);
    }
}
