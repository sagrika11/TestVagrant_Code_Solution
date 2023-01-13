### Weekly Subscription Plans

<br />


> **_My Intuition:_**  I have to find all possible combiantion of newspaper in a given budget.So my steps to approach this problem is as follow: 

<br/>

#### 1. I have stored given table data in Map,i have used linkedhashmap so,the order of data remains same according to my input. In given data there are total 5 newspaper {TOI, Hindu,ET,BM,HT} and their weekly prices are given.
<br/>

#### 2. In map i have stored newspaper name as key in the form string and their weekly prices as Value in the form of ArrayList of Float.

<br/>

#### 3. After storing i have calculated the sum of weekly price of each newspaper which are as follow 👍.
TOI - 26,
Hindu - 20.5,
ET - 34,
BM - 10.5,
HT - 18,and stored them in Map where this time WeeklySum is key and newspaper is value.
<br/>

#### 4. I have extracted the WeeklySum from map and stored in an arraylist to generate all possible combiantions.
<br/>

#### 5. To generate all possible outcomes I have used a recursive approach where there will be two possibilty either pick or not pick.

<br/>


**_Recursive Approach:_** Time complexity of this approach is 2^n.
<br/>

#### 6. There are many combinations but i have to print those combiantions which contains maximum newspapers according to the given output.

<br/>

---
**Testing output for given Input**

Test 1: Budget = 40 
 
 Possible outputcomes will be : <BR/>
 [[TOI, BM], [Hindu, BM], [Hindu, HT], [BM, HT]]


<br/>
Test 2: Budget = 35

Possible outputcomes will be : <BR/>
[[Hindu, BM], [BM, HT]]

<br/>
My testcase: Budget = 20 <br/>
Possible outputcomes will be : [[BM], [HT]]

<br/>

My testcase: Budget = 10 <br/>
Possible outputcomes will be : Not Enough Budget!!

---

## How to execute code.

Clone the project

```bash
  git clone https://github.com/sagrika11/TestVagrant_Code_Solution.git
```

Go to the project directory => src => Subscription => WeeklySubscription

To Test Input go to line 138, change budget value accordingly and run the program.


## Performed Test Case Output

![Test Image 5](https://res.cloudinary.com/amritrajmaurya/image/upload/v1673598965/2023-01-13_2_qrpvfi.png)

<br />

![Test Image 5](https://res.cloudinary.com/amritrajmaurya/image/upload/v1673598966/2023-01-13_1_xcf4g2.png)

<br />

![Test Image 5](https://res.cloudinary.com/amritrajmaurya/image/upload/v1673598965/2023-01-13_4_we3jur.png)

<br />

![Test Image 5](https://res.cloudinary.com/amritrajmaurya/image/upload/v1673598965/2023-01-13_3_tsyxpg.png)

