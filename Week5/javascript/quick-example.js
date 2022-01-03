//
console.log("Hello");

var hi = 6;
console.log(hi);

console.log("Boo");

let sum = 0;
// let sum = 6; CANNOT re-declare sum
sum = 5 + 6;

sum += 5;
sum += 6;

// sum = "Hi"; can ressign Different TYPES

for (let i = 0; i < 10; i++) {
	sum = sum + i; // simple arthimetic
	sum *= i; // does the above
	console.log(sum);
}

// is this valid? Yes and it's going to return 18 as a string

let i = 8;

console.log("1f" - i);
