# Entities

- RateLimiterType (enum)
  - FIXED_WINDOW
  - SLIDING_WINDOW
  - TOKEN_BUCKET

- RateLimiterConfig
    - Integer limit;
    - Integer timeInterval / windowSize;

- WindowInfo 
  - Integer startTime;
  - Integer endTime;
  - Integer count = 0;


# Class
- RateLimiterManager
  - RateLimiterConfig
  - RateLimiterStrategy
  + boolean allowRequest(String userId);

- RateLimiterStrategy (interface)
  + boolean allowRequest(String userId);

- FixedWindowRateLimiter
  - Map<userID, WindowInfo>
  
- SlidingWindowRateLimiter
  - Map<userID, Queue<Long>>

- RateLimiterFactory
  + RateLimiterStrategy getRateLimiter



# Technique
For implementing rate limiter we need timestamp at which user has raise request, for that we can have a queue which store the timestamp.

- FIXED_WINDOW: need request from startTime of that window and on interval need to remove the request beyond start time
- Sliding window need to keep request where time > currenttime - interval