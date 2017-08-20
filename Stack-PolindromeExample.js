var Stack = function(){
    this.count = 0;
    this.storage = [];
}
// Adds a value onto the end of the stack
Stack.prototype.push = function(value) {
    this.storage[this.count++] = value;
}

// Removes and returns the value at the end of the stack
Stack.prototype.pop = function() {
    // Check to see if the stack is empty
    if (this.count === 0) {
        return undefined;
    }

    var result = this.storage[--this.count];
    delete this.storage[this.count];
    return result;
}

// Returns the length of the stack
Stack.prototype.size = function() {
    return this.count;
}
//Checks if the stack is empty or not
Stack.prototype.isEmpty = function(){
    return this.count === 0;
}

///Polindrome example//

var letters = []; // this is a Stack

var word = "kabak";
var reverseWord = "";

//put letters of word into Stack
for (var i = 0; i < word.length; i++) {
    letters.push(word[i])
}

//pop off the stack in reverse order
for (var i = 0; i < word.length; i++) {
    reverseWord += letters.pop();    
}

if(word === reverseWord){
    console.log(word + " is a polindrome");
}else{
     console.log(word + " is not a polindrome");
}
    



