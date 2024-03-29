(ns algorithm.change-coins)

"## 문제  
	- 당신은 음식점의 계산을 도와주는 점원입니다.  
	- 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정합니다.  
	- 손님에게 거슬러 주어야 할 돈이 N원일 때 거슬러 주어야 할 동전의 최소 개수를 구하세요.  
	- 단, 거슬러 줘야 할 돈 N은 항상 10의 배수입니다.  
 ## 문제 해결 아이디어  
	- 최적의 해를 빠르게 구하기 위해서는 가장 큰 화폐 단위부터 돈을 거술러 주면 됩니다.  
	- N원을 거슬러 줘야 할 때, 가장 먼저 500원으로 거슬러 줄 수 있을 만큼 거슬러 줍니다.  
		- 이후에 100원, 50원, 10원짜리 동전을 차례대로 거슬러 줄 수 있을 만큼 거슬러 주면 됩니다.  
		-  
"

(def n 1260)
(def coins [500 100 50 10])

(defn change-coins [coins remain count]
  (if (zero? remain)
    count
    (let [coin    (first coins)
          count'  (+ count (quot remain coin))
          remain' (rem remain coin)]
      (change-coins (rest coins) remain' count'))))

(comment
  (change-coins coins n 0)
  :rcf)
