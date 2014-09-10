class test{
	public static void main(String[] args) {
		byte[] ADD={127,0,0,1};

		System.out.println("ADD " +ADD);
		System.out.println(new String(ADD));
		System.out.println("ADD.getBytes() " + "ADD".getBytes());
		System.out.println("ADD".getBytes().toString());
	}
}