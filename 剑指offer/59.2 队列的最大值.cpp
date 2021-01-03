class MaxQueue {
private:
    deque<int> mainQueue;
    deque<int> helperQueue;
public:
    MaxQueue() {

    }
    
    int max_value() {
        if (mainQueue.empty()) return -1;
        return helperQueue.front();
    }
    
    void push_back(int value) {
        mainQueue.push_back(value);

        while (!helperQueue.empty() && value > helperQueue.back()) helperQueue.pop_back();
        
        helperQueue.push_back(value);
    }
    
    int pop_front() {
        if (mainQueue.empty()) return -1;
        if (mainQueue.front() == helperQueue.front()) helperQueue.pop_front();

        int res = mainQueue.front(); 
        mainQueue.pop_front();
        return res;
    }
};