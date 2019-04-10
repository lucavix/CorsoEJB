#!/bin/bash
func(){
	for i in {1..500}; do
		n='http://localhost:8080/TurorialEARWeb/Concurrent?op='$(($i%2))
		curl $n	 &
		pids[${i}]=$!
	done

	# wait for all pids
	for pid in ${pids[*]}; do
	    wait $pid
	done
}

doTest() {
	for i in {1..5}; do
		func &
		f[${i}]=$!
		sleep 1
	done	
        for pid in ${f[*]}; do
            wait $pid
        done
}

echo "started"
doTest
echo "finished"
echo "---"
curl 'http://localhost:8080/TurorialEARWeb/Concurrent'
echo "---"

