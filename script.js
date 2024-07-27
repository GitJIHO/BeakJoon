Kakao.init('b8cd68ea35dcf9e1ae50c65c713ef408'); // 여기에 자신의 앱 키를 입력

document.getElementById('loginButton').addEventListener('click', function() {
    Kakao.Auth.login({
        scope: 'friends',
        success: function(authObj) {
            Kakao.API.request({
                url: '/v1/api/talk/friends',
                success: function(response) {
                    var friendsList = document.getElementById('friends');
                    friendsList.innerHTML = '';
                    var friends = response.elements;
                    friends.forEach(function(friend) {
                        var li = document.createElement('li');
                        li.textContent = friend.profile_nickname;
                        li.setAttribute('data-uuid', friend.uuid);
                        friendsList.appendChild(li);
                    });

                    document.getElementById('friendsList').classList.remove('hidden');
                    document.getElementById('sendMessageButton').classList.remove('hidden');
                },
                fail: function(error) {
                    console.error(error);
                    alert('친구 목록 불러오기 실패!');
                }
            });
        },
        fail: function(err) {
            console.error(err);
            alert('로그인 실패!');
        }
    });
});

document.getElementById('friends').addEventListener('click', function(event) {
    if (event.target.tagName === 'LI') {
        var selectedFriend = event.target;
        var friends = document.querySelectorAll('#friends li');
        friends.forEach(function(friend) {
            friend.style.backgroundColor = '#fff';
        });
        selectedFriend.style.backgroundColor = '#ffeb00';
        selectedFriend.classList.add('selected');
    }
});

document.getElementById('sendMessageButton').addEventListener('click', function() {
    var selectedFriend = document.querySelector('#friends li.selected');
    if (selectedFriend) {
        var friendId = selectedFriend.getAttribute('data-uuid');
        Kakao.API.request({
            url: '/v1/api/talk/friends/message/default/send',
            data: {
                receiver_uuids: [friendId],
                template_object: {
                    object_type: 'feed',
                    content: {
                        title: '멋진 이벤트 초대장!',
                        description: '놀라운 서프라이즈가 기다리고 있습니다. 지금 확인하세요!',
                        image_url: 'https://avatars.githubusercontent.com/u/161289673?v=4',
                        link: {
                            web_url: 'https://github.com/GitJIHO',
                            mobile_web_url: 'https://github.com/GitJIHO'
                        }
                    },
                    item_content: {
                        profile_text: 'Kakao 이벤트',
                        profile_image_url: 'https://avatars.githubusercontent.com/u/161289673?v=4',
                        title_image_url: 'https://avatars.githubusercontent.com/u/161289673?v=4',
                        title_image_text: '이벤트에 오신 것을 환영합니다!',
                        title_image_category: '이벤트',
                        items: [
                            {
                                item: '아이템 1',
                                item_op: '무료'
                            },
                            {
                                item: '아이템 2',
                                item_op: '무료'
                            },
                            {
                                item: '아이템 3',
                                item_op: '무료'
                            },
                            {
                                item: '아이템 4',
                                item_op: '무료'
                            },
                            {
                                item: '아이템 5',
                                item_op: '무료'
                            }
                        ],
                        sum: '총 무료 아이템',
                        sum_op: '5개'
                    },
                    social: {
                        like_count: 150,
                        comment_count: 60,
                        shared_count: 40
                    },
                    buttons: [
                        {
                            title: '웹에서 보기',
                            link: {
                                web_url: 'https://github.com/GitJIHO',
                                mobile_web_url: 'https://github.com/GitJIHO'
                            }
                        },
                        {
                            title: '앱에서 보기',
                            link: {
                                android_execution_params: 'key1=value1',
                                ios_execution_params: 'key1=value1'
                            }
                        },
                        {
                            title: '이벤트 등록하기',
                            link: {
                                web_url: 'https://your-website.com/register',
                                mobile_web_url: 'https://your-website.com/register'
                            }
                        }
                    ]
                }
            },
            success: function(response) {
                alert('메시지 전송 성공!');
            },
            fail: function(error) {
                console.error(error);
                alert('메시지 전송 실패!');
            }
        });
    } else {
        alert('메시지를 보낼 친구를 선택하세요.');
    }
});
