# PreOrderInOrderPostOrder-Binary Tree

### Steps:

* Users have to input data to make a binary tree.
* System will exit from creating a binary tree when user input 0 or any negative number. 
  (So the input field take all positive integer except 0)
* After creating binary tree user can choose his options from menu
  (User can choose 1 for pre-order, 2 for in-order and 3 for post-order traversing method)
* System will be terminated if the user presses any other digit.
___

### Test cases:
	Targeted binary tree
		       1
		  /         \
		2             3
             /     \        /    \
           4      mull    null   6
           /       \
           null     5


_Input set_: 
* 1
* 0
* 2
* 1
* L
* 3
* 1
* R
* 4
* 2
* L
* 5
* 4
* R
* 6
* 3
* R
* 0
___
After this input fields binary tree will be created and user will able to see the menu bar like:

```bash
Traverse the binary tree as
1. Pre-Order
2. In-Order
3. Post-Order
Press Any Digit For Exit
```

  * If user press 1 then output would be like:
     * _Output: 1 2 4 5 3 6_ 
  * If user press 2 then the output will be like:
    * _Output: 4 5 2 1 3 6_ 

  * If user press 3 then the output will be like:
    * _Output: 5 4 2 6 3 1_ 

* Worst cases:
   * System can throw an exception if the root node is not found.
   * System can throw an exception if the user input any string or characters as node data.
