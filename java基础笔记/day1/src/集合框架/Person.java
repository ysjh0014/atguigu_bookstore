package ���Ͽ��;

public  class Person implements Comparable{
	   private String name;
	    private Integer age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		@Override
		//����TreeSet�����Person��Ķ���ʱ�����ݴ˷�����ȷ�������ĸ���������
		public int compareTo(Object o) {
		if(o instanceof Person){//instanceof�����������ж�ĳ�������Ƿ���ĳ�������Ƿ���ĳ�����͵Ķ���
			Person p=(Person)o;
			int i=this.age.compareTo(p.age);
			if(i==0){
				return this.name.compareTo(p.name);
			}
			else{
				return i;
			}
		}
			return 0;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((age == null) ? 0 : age.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age == null) {
				if (other.age != null)
					return false;
			} else if (!age.equals(other.age))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
}
