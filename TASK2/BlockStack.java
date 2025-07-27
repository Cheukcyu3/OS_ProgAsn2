package OS_PROGASN2.TASK2;
/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	private static int stack_access_counter = 0;
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '*', '*'};

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '*';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{	
		++stack_access_counter;
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{	
		++stack_access_counter;
		try{
			if(piPosition < 0 || piPosition > iTop ){
				throw new stackEmptyException("piPosition is out of bounds!");
			}else{
				return this.acStack[piPosition];
			}
		}catch(stackEmptyException e){
			System.out.println("Error: " + e.getMessage());
		}
		return '\0';
		
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock)
	{
		++stack_access_counter;
		try{
			if(isFull()){
				throw new stackEmptyException("Full Stack !!!");
			}else if(this.isEmpty()){
				this.acStack[++this.iTop] = 'a';
			}else{
				this.acStack[++this.iTop] = pcBlock;
			}
		}catch(stackEmptyException e){
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Successful push");
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop()
	{
		++stack_access_counter;
		try{
			char cBlock = this.acStack[this.iTop];
			if(!this.isEmpty()){
				this.acStack[this.iTop--] = '*'; // Leave prev. value undefined
				System.out.println("Successful pop");
				return cBlock;
			}else{
				throw new stackEmptyException("Empty Stack !!!");
			}
		}catch(stackEmptyException e){
			System.out.println("Error " + e.getMessage());
		}
		return '\0';
	}

	public int getTop(){
		return iTop;
	}

	public int getSize(){
		return iSize;
	}

	public int getAccessCounter(){
		return stack_access_counter;
	}

	public boolean isEmpty(){
		return (this.iTop == -1);
	}

	/*
	 * Added an isFull function for using
	 * in the 
	 */
	public boolean isFull(){
		return (this.iTop==this.acStack.length-1);
	}

	@Override public String toString(){
	StringBuilder string = new StringBuilder("acStack: ");
		for (char elem : acStack) {
			string.append(elem);
		}
	return string.toString();
	}
}


// EOF
