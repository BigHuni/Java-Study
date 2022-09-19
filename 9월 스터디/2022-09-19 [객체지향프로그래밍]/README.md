## 🔸 2022-09-19 월요일

## [객체지향프로그래밍]

### 1. Set 인터페이스

- Iterator로 순회하기
    - `set`은 get[i]를 가져오는 것이 아니라 `Iterator`를 이용해서 순회하는 것

<br>

- MemberHashSet 생성

```
    private HashSet<Member> hashset;
	
	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}
	
	public void addMember(Member member) {
		hashSet.add(member);
	}	
```

- member 추가 시 `public void addMember(Member member)`
- member 삭제 시 `public boolean removeMember(int memberId)` => memberId를 알아야 삭제 가능
- memberId를 알려면, 각각 memberId를 순회하면서 확인해야함 => `Iterator` 활용

```
    public boolean removeMember(int memberId) {
		
		Iterator<Member> ir = hashSet.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			if (member.getMemberId() == memberId) {
				hashSet.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "번호가 존재하지 않습니다.");
		return false;
	}
```

- Iterator는 <Member> 를 순회
- while 문으로 `ir.next()` 가져옴
- memberId가 지울 memberId가 같으면(==), `hashSet.remove(member)`
- while 문이 전부 돌았는데, 조건에 걸리지 않았다면 해당 memberId가 없다는 것이니 `출력문`과 `return false`

<br>

```
    MemberHashSet manager = new MemberHashSet();
		
		Member memberLee = new Member(100, "Lee");
		Member memberKim = new Member(200, "Kim");
		Member memberPark = new Member(300, "Park");
		Member memberPark2 = new Member(300, "Park2");
		
		manager.addMember(memberLee);
		manager.addMember(memberKim);
		manager.addMember(memberPark);
		manager.addMember(memberPark2);
		
		manager.showAllMember();
		
		manager.removeMember(100);
		manager.showAllMember();
```

- memberPark와 memberPark2가 둘다 memberId가 300으로 동일
- memberId는 유일한 값이어야 함
- String 같은 경우, 중복으로 값이 들어가지 않지만, memberId는 중복으로 들어가는 이유
- 두 멤버가 같다는 것을 정의하지 않았기 때문
- String은 jdk 안에서 정의가 되고, Member에 대해 id가 같으면 같은 멤버라는게 논리적인 구현이 되어 있지 않음
- 이 구현은 Member 클래스에서 구현하면 됨

```
    @Override
	public int hashCode() {
		return memberId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			
			return(this.memberId == member.memberId);
		}
		
		return false;
	}
```

- 논리적으로 같다는 것을 구현 => `@Override`로 `hashCode()`와 `equals()` 재정의
- `equals()`는 `if(obj instanceof Member)`로 멤버 지정하고, obj를 member로 다운캐스팅
- 같은지 여부를 반환하고, 아닌 것은 false 반환 => 이것이 같다는 정의
- `hashCode()`는 Integer를 generator 하는 방법
- 같은 member일 때, 같은 hashCode를 가지면 되니까 동일한 memberId를 바로 반환
- MemberhashSetTest의 출력 결과로 memberId의 값 300이 중복으로 들어가지 않음
- HashSet을 사용할 때, 이것이 관리할 Object(객체)가 논리적으로 같다는 정의가 되어있지 않다면 이를 재정의해야 함
- Integer, String 이런 기존의 클래스들은 이미 jdk에서 정의되어 있으므로 값이 정상적으로 잘 들어감

<br>

- Set 인터페이스 정리
    - Collection 하위의 인터페이스
    - 중복을 허용하지 않음
    - List는 순서 기반의 인터페이스지만, Set은 순서가 없음
    - get(i) 메서드가 제공되지 않음(Iterator로 순회)
    - 저장된 순서와 출력 순서는 다를 수 있음
    - 아이디, 주민번호, 사번 등 유일한 값이나 객체를 관리할 때 사용
    - HashSet, TreeSet 클래스

<br>

- HashSet 클래스 정리
    - Set 인터페이스를 구현한 클래스
    - 중복을 허용하지 않으므로 저장되는 객체의 동일함 여부를 알기 위해 equals()와 hashCode() 메서드를 재정의해야 함

<br>

- TreeSet 클래스 정리
    - 객체의 정렬에 사용되는 클래스
    - 중복을 허용하지 않으면서 오름차순이나 내림차순으로 객체를 정렬함
    - 내부적으로 이진 검색 트리(binary search tree)로 구현되어 있음
    - 이진 검색 트리에 자료가 저장될 때 비교하여 저장될 위치를 정함
    - 객체 비교를 위해 Comparable이나 Comparator 인터페이스를 구현해야 함

<br>

## 🔖 Eclipse 실습

![hashset_list2](https://user-images.githubusercontent.com/79084294/191032101-e3d0c257-98c5-4213-89bb-d91323328ba7.png)

<br>

## 🔖 Eclipse 출력 Console

![hashset_console2](https://user-images.githubusercontent.com/79084294/191032108-48bf5f99-5326-45e9-a802-cf4dd9ba5f7c.png)
